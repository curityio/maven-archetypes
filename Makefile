all: test

test:
	cd authenticator-archetype && mvn clean integration-test

deploy:
	cd authenticator-archetype && mvn clean deploy

clean:
	cd authenticator-archetype && mvn clean

