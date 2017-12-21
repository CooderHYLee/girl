#!/bin/bash
cd "$(dirname "$0")"
docker-compose up -d --build
docker-compose logs -f