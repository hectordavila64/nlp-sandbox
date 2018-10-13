TAG=nlp-sandbox
DOCKER_RUN=docker run -it -v $(shell pwd)/src:/nlp-sandbox/src -v $(shell pwd)/corpus:/nlp-sandbox/corpus $(TAG)

run:
	@ $(DOCKER_RUN) ./gradlew --no-daemon -q run

console:
	@ $(DOCKER_RUN)

test:
	@ $(DOCKER_RUN) ./gradlew --no-daemon -q test

install:
	@ docker build -t $(TAG) .

remove:
	@ docker rmi $(TAG)

show:
	@ docker ps --format "table {{.ID}}\t{{.Image}}\t{{.Mounts}}\t{{.Ports}}\t{{.Names}}"