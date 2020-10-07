# Start from GridGain Professional image.
FROM gridgain/gridgain-pro:8.7.9

# Set config uri for node.
ENV CONFIG_URI ImportedCluster-server.xml

# Copy optional libs.
ENV OPTION_LIBS ignite-rest-http

# Update packages and install maven.
RUN set -x \
    && apk add --no-cache \
        openjdk8

RUN apk --update add \
    maven \
    && rm -rfv /var/cache/apk/*

# Append project to container.
ADD . ImportedCluster

# Build project in container.
RUN mvn -f ImportedCluster/pom.xml clean package -DskipTests

# Copy project jars to node classpath.
RUN mkdir $IGNITE_HOME/libs/ImportedCluster && \
   find ImportedCluster/target -name "*.jar" -type f -exec cp {} $IGNITE_HOME/libs/ImportedCluster \;