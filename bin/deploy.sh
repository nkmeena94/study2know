#! /bin/bash

checkIfStarted() {
	PORT=$1
	echo "checking for PORT $PORT"
	status=7
	count=0
	while [ ! "$status" == 0 -a $count -lt 50 ] 
	do
		echo "check count ${count}(status : ${status}) - Going to sleep for 20 Secs"
		sleep 20
		curl -X GET "http://localhost:${PORT}/api/xeno/v0/ping" > /dev/null 2>&1
		status=$?
		count=$((count+1))
	done
	if [ $status != 0 ] 
	then
		echo "startup failed"
		exit 1
	fi
}

P1=9000
P2=9100

cd $XENO_HOME

if [ ! -z $1 ] 
then
	if [$1 == "C" ] 
	then
		svn up
	else
        	ver="-r$1"
		svn up $ver
	fi	
fi

export APP_PORT=$P1
export ADMIN_PORT=$((P1+1))
export DEBUG_PORT=$((P1+5))
$XENO_HOME/bin/startup.sh restart 

checkIfStarted $P1
echo "Server $PORT started"

export APP_PORT=$P2
export ADMIN_PORT=$((P2+1))
export DEBUG_PORT=$((P2+5))
$XENO_HOME/bin/startup.sh restart

checkIfStarted $P2
echo "Server $PORT started"


