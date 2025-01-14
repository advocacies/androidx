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

package com.example.androidx.mediarouting.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidx.mediarouting.R;
import com.example.androidx.mediarouting.activities.MainActivity;
import com.example.androidx.mediarouting.data.PlaylistItem;
import com.example.androidx.mediarouting.session.SessionManager;

import org.jspecify.annotations.NonNull;

/**
 * {@link ListView} {@link Adapter} for showing items in the playlist listview.
 */
public final class PlaylistAdapter extends ArrayAdapter<PlaylistItem> {

    private final MainActivity mActivity;
    private final SessionManager mSessionManager;

    public PlaylistAdapter(@NonNull MainActivity mainActivity,
            @NonNull SessionManager sessionManager) {
        super(mainActivity, R.layout.media_item);
        this.mActivity = mainActivity;
        this.mSessionManager = sessionManager;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View v;
        if (convertView == null) {
            v = mActivity.getLayoutInflater().inflate(R.layout.media_item, null);
        } else {
            v = convertView;
        }

        final PlaylistItem item = getItem(position);

        TextView tv = v.findViewById(R.id.item_text);
        tv.setText(item.toString());

        ImageButton b = v.findViewById(R.id.item_action);
        b.setImageResource(R.drawable.ic_menu_delete);
        b.setTag(item);
        b.setOnClickListener(v1 -> mSessionManager.remove(item.getItemId()));

        return v;
    }
}
