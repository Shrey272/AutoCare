FROM tomcat:9.0-jdk8-openjdk-slim

# Remove default Tomcat apps
RUN rm -rf /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/examples /usr/local/tomcat/webapps/docs

# Copy web files
WORKDIR /usr/local/tomcat/webapps/AutoCare
COPY web/ .

# Ensure classes directory exists
RUN mkdir -p /usr/local/tomcat/webapps/AutoCare/WEB-INF/classes

# Copy Java source code and compile using javac
COPY src/java /tmp/src
RUN javac -cp "/usr/local/tomcat/webapps/AutoCare/WEB-INF/lib/*:/usr/local/tomcat/lib/*" \
    $(find /tmp/src -name "*.java") \
    -d /usr/local/tomcat/webapps/AutoCare/WEB-INF/classes && \
    rm -rf /tmp/src

# Root redirect: forwards root "/" to "/AutoCare/"
RUN mkdir -p /usr/local/tomcat/webapps/ROOT && \
    echo '<% response.sendRedirect(request.getContextPath() + "/AutoCare/"); %>' > /usr/local/tomcat/webapps/ROOT/index.jsp

EXPOSE 8080

CMD ["catalina.sh", "run"]
