DOCKER_IMAGE = console-dungeon

build:
		@docker build -t $(DOCKER_IMAGE) .
run: 
		@docker run --rm -i -v  "$(CURDIR)/src:/app/src" $(DOCKER_IMAGE)
