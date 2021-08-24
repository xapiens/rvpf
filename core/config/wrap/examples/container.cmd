REM $Id: container.cmd 3191 2016-09-27 14:42:51Z SFB $

CALL "%RVPF_CONFIG%/wrap/common"

SET MAIN_CLASS=org.rvpf.container.ContainerServiceActivator

SET CLASS_PATH=%CLASS_PATH%;%RVPF_CORE_SHARE_JAVA%/rvpf-store.jar
SET CLASS_PATH=%CLASS_PATH%;%RVPF_CORE_SHARE_JAVA%/rvpf-processor.jar
SET CLASS_PATH=%CLASS_PATH%;%RVPF_CORE_SHARE_JAVA%/rvpf-http.jar
SET CLASS_PATH=%CLASS_PATH%;%RVPF_CORE_SHARE_JAVA%/rvpf-forwarder.jar

SET JVM_OPTIONS=%JVM_OPTIONS%;-Drvpf.log.prefix=container
SET JVM_OPTIONS=%JVM_OPTIONS%;-Drvpf.log.size=5MB
SET JVM_OPTIONS=%JVM_OPTIONS%;-Drvpf.log.backups=25
SET JVM_OPTIONS=%JVM_OPTIONS%;-Drvpf.log.id=Cont

SET INITIAL_MEMORY=16
SET MAXIMUM_MEMORY=256

SET LOG_PREFIX=container

SET SERVICE_NAME=RVPFContainer
SET SERVICE_DISPLAY_NAME=RVPF Container
SET SERVICE_DESCRIPTION=RVPF Container Service
SET SERVICE_DEPENDS_ON=TCPIP

REM End.
