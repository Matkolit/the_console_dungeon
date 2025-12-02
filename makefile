DOCKER_IMAGE = console-dungeon

build:
		@docker build -t $(DOCKER_IMAGE) .
run: 
		@docker run --rm -v "$(PWD)/src":/app/src $(DOCKER_IMAGE)
