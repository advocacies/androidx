/*
 * Copyright 2023 The Android Open Source Project
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

package androidx.test.uiautomator.util;

import androidx.annotation.RestrictTo;

import org.jspecify.annotations.NonNull;

import java.util.regex.Pattern;

/** Static regex utilities. */
@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class Patterns {

    private Patterns() {}

    /**
     * Returns a {@link Pattern} that matches when content starts with given string
     * (case-sensitive).
     */
    public static @NonNull Pattern startsWith(@NonNull String text) {
        return Pattern.compile(String.format("^%s.*$", Pattern.quote(text)), Pattern.DOTALL);
    }

    /**
     * Returns a {@link Pattern} that matches when content ends with given string
     * (case-sensitive).
     */
    public static @NonNull Pattern endsWith(@NonNull String text) {
        return Pattern.compile(String.format("^.*%s$", Pattern.quote(text)), Pattern.DOTALL);
    }

    /**
     * Returns a {@link Pattern} that matches when content contains given string (case-sensitive).
     */
    public static @NonNull Pattern contains(@NonNull String text) {
        return Pattern.compile(String.format("^.*%s.*$", Pattern.quote(text)), Pattern.DOTALL);
    }
}
