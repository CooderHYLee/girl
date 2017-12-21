#!/bin/bash
cd "$(dirname "$0")"
docker-compose down -v --rmi local
sudo rm -rf ./maven ./mysqldb ./mysql