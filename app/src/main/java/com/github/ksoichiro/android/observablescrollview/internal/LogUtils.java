/*
 * Copyright 2014 Soichiro Kashima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.ksoichiro.android.observablescrollview.internal;

import android.util.Log;

import com.hustunique.bocp.BuildConfig;

public class LogUtils {
    public static boolean enabled = BuildConfig.DEBUG;

    public static void v(final String tag, final String message) {
        if (enabled) {
            Log.v(tag, message);
        }
    }
}
