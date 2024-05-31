/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.camera.camera2.pipe.integration.compat.quirk

import android.annotation.SuppressLint
import android.os.Build

/**
 * QuirkSummary
 * - Bug Id: b/227469801, b/274738266
 * - Description: Quirk indicates Preview is stretched when VideoCapture is bound.
 * - Device(s): Samsung J3, Samsung J5, Samsung J7, Samsung J1 Ace neo and Oppo A37F
 */
@SuppressLint("CameraXQuirksClassDetector")
class PreviewStretchWhenVideoCaptureIsBoundQuirk : CaptureIntentPreviewQuirk {

    companion object {
        fun isEnabled(): Boolean {
            return isHuaweiP8Lite() ||
                isSamsungJ3() ||
                isSamsungJ7() ||
                isSamsungJ1AceNeo() ||
                isOppoA37F() ||
                isSamsungJ5()
        }

        private fun isHuaweiP8Lite(): Boolean {
            return "HUAWEI".equals(Build.MANUFACTURER, true) &&
                "HUAWEI ALE-L04".equals(Build.MODEL, true)
        }

        private fun isSamsungJ3(): Boolean {
            return "Samsung".equals(Build.MANUFACTURER, true) &&
                "sm-j320f".equals(Build.MODEL, true)
        }

        private fun isSamsungJ5(): Boolean {
            return "Samsung".equals(Build.MANUFACTURER, true) &&
                "sm-j510fn".equals(Build.MODEL, true)
        }

        private fun isSamsungJ7(): Boolean {
            return "Samsung".equals(Build.MANUFACTURER, true) &&
                "sm-j700f".equals(Build.MODEL, true)
        }

        private fun isSamsungJ1AceNeo(): Boolean {
            return "Samsung".equals(Build.MANUFACTURER, true) &&
                "sm-j111f".equals(Build.MODEL, true)
        }

        private fun isOppoA37F(): Boolean {
            return "OPPO".equals(Build.MANUFACTURER, true) && "A37F".equals(Build.MODEL, true)
        }
    }
}