#
# Copyright (C) 2012 The CyanogenMod Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

## Specify phone tech before including full_phone
$(call inherit-product, vendor/slim/config/gsm.mk)

# Release name
PRODUCT_RELEASE_NAME := p3100

# Boot animation hack
TARGET_BOOTANIMATION_NAME := horizontal-1024x600

# Boot animation
TARGET_SCREEN_HEIGHT := 1024
TARGET_SCREEN_WIDTH := 600

# Inherit some common Slim stuff.
$(call inherit-product, vendor/slim/config/common_full_phone.mk)

# Boot Animation
PRODUCT_COPY_FILES +=  \
vendor/slim/prebuilt/hdpi/bootanimation.zip:system/media/bootanimation.zip

# Inherit device configuration
$(call inherit-product, device/samsung/p3100/full_p3100.mk)

## Device identifier. This must come after all inclusions
PRODUCT_DEVICE := p3100
PRODUCT_NAME := slim_p3100
PRODUCT_BRAND := samsung
PRODUCT_MODEL := GT-P3100
PRODUCT_MANUFACTURER := samsung

#Set build fingerprint / ID / Prduct Name ect.
PRODUCT_BUILD_PROP_OVERRIDES += PRODUCT_NAME=espressorfxx TARGET_DEVICE=espressorf BUILD_FINGERPRINT=samsung/espressorfxx/espressorf:4.0.3/IML74K/P3100XWALE2:user/release-keys PRIVATE_BUILD_DESC="espressorfxx-user 4.0.3 IML74K P3100XWALE2 release-keys"
