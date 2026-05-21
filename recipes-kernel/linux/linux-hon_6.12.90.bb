DESCRIPTION = "Linux Stable from git"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS = "lzop-native"

PROVIDES += "virtual/kernel"

inherit kernel kernel-deploy-oftree

KERNEL_GIT = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git"

# Version v6.6.32
#SRCREV = "91de249b6804473d49984030836381c3b9b3cfb0"

# Version v6.12.90
SRCREV = "2538fbeff8a94ee2b54eb09d92209e24a1e650d4"

SRC_URI = "${KERNEL_GIT};branch=linux-6.12.y \
	    file://defconfig \
        file://page-owner.cfg \
	  "

#SRC_URI:append:dev = " file://dev.cfg \
#                     "
#SRC_URI:append = " file://0001-init-cmdline.patch"

S = "${WORKDIR}/git"

do_sth() {
    bbplain "WORKDIR: " ${WORKDIR}
    bbplain "BP: " ${BP}
    bbplain "IMAGE_INSTALL: " ${IMAGE_INSTALL}
    bbplain "MACHINE_ESSENTIAL_EXTRA_RDEPENDS: " ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS}
    bbplain "OVERRIDES: " ${OVERRIDES}
#    bbplain "SRC_URI: " ${SRC_URI}
}

addtask sth before do_configure

