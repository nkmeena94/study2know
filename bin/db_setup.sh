#! /bin/bash

[ -z "$XENO_HOME" ] && echo "App Home is not set. Exiting" && exit 1
[ ! -e "$XENO_HOME" ] && echo "App Home Dir does not exist. Exiting" && exit 2

data_dir=${XENO_HOME}/db
schema_def=${XENO_HOME}/master/src/gen/resources/migrations/db.changelog-1.0.sql.gen

[ ! -f "$schema_def" ] && echo "Database schema definition file [$schema_def] does not exist. Exiting" && exit 2

echo "droping database"
echo "drop database $MY_DB" | $MYSQL_CON

echo "creating database"
echo "create database $MY_DB" | $MYSQL_CON

echo "creating tables"
cat $schema_def | grep create | $MYSQL_CON -D $MY_DB

#echo "uploading seed data"
#. $data_dir/loaddata.sh
