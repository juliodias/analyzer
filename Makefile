run-application:
	@echo "Creating containers to run analyzer application..."
	docker-compose -f docker/docker-compose.yml up -d;

	sleep 5;

	@echo "Running analyzer application..."
	./mvnw spring-boot:run
