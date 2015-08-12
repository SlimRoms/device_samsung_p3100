LOCAL_PATH:= $(call my-dir)

# recovery.img parts
include $(CLEAR_VARS)
LOCAL_MODULE       := init.recovery.espresso.rc
LOCAL_MODULE_TAGS  := optional eng
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := ../recovery/root/init.recovery.espresso.rc
LOCAL_MODULE_PATH  := $(TARGET_RECOVERY_ROOT_OUT)
include $(BUILD_PREBUILT)
