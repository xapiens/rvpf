REM $Id: common.cmd 3813 2018-11-10 20:44:07Z SFB $

SET JVM_OPTIONS=%JVM_OPTIONS%;-client

SET CLASS_PATH=%RVPF_CONFIG%/service/local;%RVPF_CONFIG%/service

SET LIBRARY_PATH=%RVPF_CORE_LIB%

SET INITIAL_MEMORY=4
SET MAXIMUM_MEMORY=64

SET USER_LANGUAGE=en

REM End.
