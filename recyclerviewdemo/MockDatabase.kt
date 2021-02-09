package com.example.recyclerviewdemo

class MockDatabase {
    companion object {
        fun createMockData(): ArrayList<Post> {
            val list = ArrayList<Post>()
            for (i in 0 until 30) {
                val imageToSelect = when (i % 4) {
                    0 -> R.drawable.ic_baseline_ac_unit
                    1 -> R.drawable.ic_baseline_account
                    2 -> R.drawable.ic_baseline_account_circle
                    3 -> R.drawable.ic_baseline_add_location
                    else -> R.drawable.ic_baseline_home
                }
                list.add(
                    Post(
                        imageToSelect,
                        title = "Title post of $i",
                        body = "Body of post $i"
                    )
                )
            }
            return list
        }
    }
}