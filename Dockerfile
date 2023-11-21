# Use a imagem oficial do Tomcat como a base
FROM tomcat:9.0-jdk8-openjdk-slim
# Copie o arquivo WAR para o diretório de implantação do Tomcat
COPY target/cn-agendamento-exame-consulta-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
# Exponha a porta que o Tomcat estará escutando (por padrão, o Tomcat usa a porta 8080)
EXPOSE 8059
# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]
