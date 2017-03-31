#!/usr/bin/env bash
killprocess()
{
    PROCESS=${1}
    ignore=`basename $0`
    if [ ! -z "${PROCESS}" ]; then
        _processes=( `ps -fu$USER | ${GREP} ${PROCESS} | ${GREP} -v ${ignore} | grep -v "grep" | awk '{print $2}'` )
    else
        _processes=( `status -s | awk '{print $2}'` )
    fi
    for process in ${_processes[@]}
    do
        echo Killing ${PROCESS} process with PID = ${process}
        kill -kill $process
    done
}

status(){

    echo " -- Status for Study2Know APP"
    ps -fu$USER | ${GREP} java | ${GREP} -e master

    echo " -- Status for DB Agent"
    ps -fu$USER | ${GREP} java | ${GREP} -e 'db-agent'

    echo " -- Status for Machine Agent"
    ps -fu$USER | ${GREP} java | ${GREP} -e 'machineagent'
}

start() {
    mkdir -p /home/champ/S2K/study2know/logs
    #rm -rf $XENO_HOME/logs/nohup.out
    cd /home/champ/S2K/study2know/logs
	[ -z ${DEBUG_PORT} ] && DEBUG_PORT=4999
    Study2Know_VERSION="1-SNAPSHOT"
    javaagent=javaagent.jar
    #javaagent=newrelic.jar
    export JAVA_OPTS="-Xms512m -Xmx1024m -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT"
    [ -e "${JAVA_AGENT_HOME}/${javaagent}" ] && JAVA_AGENT="-javaagent:${JAVA_AGENT_HOME}/${javaagent}"
    [ ! -e "${JAVA_AGENT_HOME}/${javaagent}" ] && echo "JAVA AGENT JAR not found. Monitoring agent wont be enabled"
    echo > /home/champ/S2K/study2know/logs/nohup.out
    nohup java `echo $JAVA_OPTS` `echo $JAVA_AGENT` -jar /home/champ/S2K/study2know/master/build/libs/Study2Know.jar server /home/champ/S2K/study2know/master/properties.yml & > /home/champ/S2K/study2know/logs/err.log

    tail -f /home/champ/S2K/study2know/logs/nohup.out
}
usage() {
    echo 'startup.sh start|stop|restart|status|machineagent|dbagent'
}

start_machine_agent() {
	killprocess "machineagent"
	mkdir /tmp/apd_ma
	cd /tmp/apd_ma
	nohup java -jar ${MACHINE_AGENT_HOME}/machineagent.jar & > err.log 
}

start_db_agent() {
	killprocess "db-agent"
	mkdir /tmp/apd_dba
	cd /tmp/apd_dba
	nohup java -jar ${DB_AGENT_HOME}/db-agent.jar & > err.log 
}

export DB_AGENT_HOME=/home/champ/S2K/study2know/agents/db
export MACHINE_AGENT_HOME=/home/champ/S2K/study2know/agents/machine
#export JAVA_AGENT_HOME=/home/champ/S2K/study2know/bin/newrelic
export GREP="grep"
case "$1" in
    "start"     ) start ;;
    "stop"      ) killprocess "address=$DEBUG_PORT" ;;
    "restart"   ) killprocess "address=$DEBUG_PORT" ; start ;;
    "status"    ) status ;;
    "machineagent" ) start_machine_agent ;;
    "dbagent"     )  start_db_agent ;;
    ""|*        ) usage ; exit 1 ;;
esac
