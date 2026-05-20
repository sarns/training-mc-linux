SUMMARY = "Honeywell device image"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

IMAGE_FEATURES:append = " ssh-server-openssh"

IMAGE_INSTALL:append = " util-linux"
IMAGE_INSTALL:append = " strace"
IMAGE_INSTALL:append = " dtc"
IMAGE_INSTALL:append = " trace-cmd"

IMAGE_INSTALL:append = " ip-setup"