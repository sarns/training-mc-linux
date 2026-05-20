# Recipe for adding systemd unit file to target
#

SUMMARY = "setup ip devices with systemd units"
DESCRIPTION = "Copy network unit files to their folder"

LICENSE = "MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
inherit systemd

# SYSTEMD_AUTO_ENABLE = "enable"
# SYSTEMD_SERVICE_${PN} = "urand.service"

SRC_URI:append = " file://80-ethernet.network"

FILES:${PN} += "${systemd_unitdir}/network/80-ethernet.network"

do_install:append() {
        install -d ${D}/${systemd_unitdir}/network
        install -m 0644 ${WORKDIR}/80-ethernet.network ${D}/${systemd_unitdir}/network
}

