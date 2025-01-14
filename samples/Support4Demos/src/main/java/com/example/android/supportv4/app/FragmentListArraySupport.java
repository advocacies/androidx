/*
 * Copyright (C) 2010 The Android Open Source Project
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

package com.example.android.supportv4.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;

import com.example.android.supportv4.LoremIpsum;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Demonstration of using ListFragment to show a list of items
 * from a canned array.
 */
public class FragmentListArraySupport extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the list fragment and add it as our sole content.
        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            ArrayListFragment list = new ArrayListFragment();
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
        }
    }

    public static class ArrayListFragment extends ListFragment {

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, LoremIpsum.TITLES));
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }
    }
}
