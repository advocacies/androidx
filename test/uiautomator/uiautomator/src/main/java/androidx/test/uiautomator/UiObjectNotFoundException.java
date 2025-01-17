/*
 * Copyright (C) 2012 The Android Open Source Project
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

package androidx.test.uiautomator;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Generated in test runs when a {@link UiSelector} selector could not be matched
 * to any UI element displayed.
 */
public class UiObjectNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public UiObjectNotFoundException(@NonNull String msg) {
        super(msg);
    }

    public UiObjectNotFoundException(@NonNull String detailMessage, @Nullable Throwable throwable) {
        super(detailMessage, throwable);
    }

    public UiObjectNotFoundException(@Nullable Throwable throwable) {
        super(throwable);
    }
}
