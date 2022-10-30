#!/bin/bash

# var prepare
dockerComposeFile=deployMongoCluster-dockerCompose.yml

startLogs() {
    echo "#### start docker logs"
#  docker compose -f $dockerComposeFile logs --follow --timestamps > ../dockerLogs/deployMongoCluster-dockerCompose.logs
    docker logs testLog -f > ../dockerLogs/testLog.logs &
    docker logs myMongoConf1 -f > ../dockerLogs/myMongoConf1.logs &
    docker logs myMongoConf2 -f > ../dockerLogs/myMongoConf2.logs &
    docker logs myMongoConf3 -f > ../dockerLogs/myMongoConf3.logs &
    docker logs myMongodS0N1 -f > ../dockerLogs/myMongodS0N1.logs &
    docker logs myMongodS0N2 -f > ../dockerLogs/myMongodS0N2.logs &
    docker logs myMongodS0N3 -f > ../dockerLogs/myMongodS0N3.logs &
    docker logs myMongodS1N1 -f > ../dockerLogs/myMongodS1N1.logs &
    docker logs myMongodS1N2 -f > ../dockerLogs/myMongodS1N2.logs &
    docker logs myMongodS1N3 -f > ../dockerLogs/myMongodS1N3.logs &
    docker logs myMongodS2N1 -f > ../dockerLogs/myMongodS2N1.logs &
    docker logs myMongodS2N2 -f > ../dockerLogs/myMongodS2N2.logs &
    docker logs myMongodS2N3 -f > ../dockerLogs/myMongodS2N3.logs &
    docker logs myMongoRSInit -f > ../dockerLogs/myMongoRSInit.logs &
    docker logs myMongodS0Init -f > ../dockerLogs/myMongodS0Init.logs &
    docker logs myMongodS1Init -f > ../dockerLogs/myMongodS1Init.logs &
    docker logs myMongodS2Init -f > ../dockerLogs/myMongodS2Init.logs &
    docker logs myMongos1 -f > ../dockerLogs/myMongos1.logs &
    docker logs myMongos2 -f > ../dockerLogs/myMongos2.logs &
    docker logs myMongos3 -f > ../dockerLogs/myMongos3.logs &
    docker logs myMongoDataPrepare -f > ../dockerLogs/myMongoDataPrepare.logs &
}

stopLogs() {
  echo "#### stop docker logs"
#  kill -9 $(pgrep -f "$dockerComposeFile logs --follow --timestamps")
  kill -9 $(pgrep -f "docker logs")
}

showLogs(){
  echo "#### showLogs of mongocluster "
#  docker compose -f $dockerComposeFile logs --follow
  ps -ef|grep "docker logs"|grep -v grep
}

up() {
  echo "#### start mongo cluster "
#  docker compose -f $dockerComposeFile logs --follow --timestamps > ../dockerLogs/deployMongoCluster-dockerCompose.logs & //failed not work
  docker compose -f $dockerComposeFile -p mymongocluster up -d
  startLogs
}

down() {
   echo "#### stop mongo cluster "
   docker compose -f $dockerComposeFile -p mymongocluster down
   stopLogs
}

start() {
  echo "#### start mongo cluster "
#  docker compose -f $dockerComposeFile logs --follow --timestamps > ../dockerLogs/deployMongoCluster-dockerCompose.logs & //failed not work
  docker compose -f $dockerComposeFile -p mymongocluster start
  startLogs
}

stop() {
   echo "#### stop mongo cluster "
   docker compose -f $dockerComposeFile -p mymongocluster stop
   stopLogs
}

clean() {
  down
  echo "#### clean mongo cluster data, log files"
  rm -rf ../mongoLogs/*
  rm -rf ../dockerLogs/*
  rm -rf ../mongoDBs/*
}

check() {
  echo "#### health check"
  echo "#### compose projects status"
  docker compose ls
  echo "#### running containers status"
  docker ps
  echo "#### networks status"
  docker network ls
}

# ANSI Colors
echoRed() { echo $'\e[0;31m'"$1"$'\e[0m'; }
echoGreen() { echo $'\e[0;32m'"$1"$'\e[0m'; }
echoYellow() { echo $'\e[0;33m'"$1"$'\e[0m'; }

echoUsage() { echoYellow "Usage: $0 {up|down|clean|start|stop|check|logs}"; exit 1; }

main() {
  action=$1

  if [[ "$action" == "up" ]]; then
    up;
  elif [[ "$action" == "down" ]]; then
    down;
  elif [[ "$action" == "clean" ]]; then
    clean;
  elif [[ "$action" == "start" ]]; then
    start;
  elif [[ "$action" == "stop" ]]; then
    stop;
  elif [[ "$action" == "check" ]]; then
    check;
  elif [[ "$action" == "logs" ]]; then
    showLogs;
  else
    echoUsage;
  fi
}

# docker compose build
# docker compose create
# docker compose down
# docker compose up
# docker compose pause
# docker compose start
# docker compose stop
# docker compose restart
# docker compose

# docker compose -f $dockerComposeFile logs --follow --timestamps > ../dockerLogs/deployMongoCluster-dockerCompose.logs &
# docker compose -f $dockerComposeFile logs --follow mymongocluster
# docker compose -f $dockerComposeFile -p mymongocluster up -d
# docker compose -f $dockerComposeFile -p mymongocluster down


main "$@"