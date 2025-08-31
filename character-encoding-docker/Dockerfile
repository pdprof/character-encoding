FROM openliberty/open-liberty:full-java11-openj9-ubi

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

USER root
# make is for snapit
# porcps-ng is for vmstat, ps, top (in linperf.sh)
# net-tools is for netstat (in inperf.sh)
# gdb is for gcore
RUN dnf install -y make procps-ng net-tools gdb nmap
COPY --chown=1001:0 config/server.xml /config/server.xml
COPY --chown=1001:0 config/jvm.options /config/jvm.options
COPY --chown=1001:0 apps/character-encoding.ear /config/apps/

USER 1001
