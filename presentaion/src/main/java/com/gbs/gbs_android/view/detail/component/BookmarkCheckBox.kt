package com.gbs.gbs_android.view.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gbs.gbs_android.R

@Composable
fun BookmarkCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Image(
        modifier = Modifier
            .size(40.dp)
            .padding(top = 10.dp, end = 10.dp)
            .clickable { onCheckedChange(!checked) },
        painter = if (!checked) painterResource(id = R.drawable.bookmark_unchecked) else painterResource(id = R.drawable.bookmark_checked),
        contentDescription = "bookmark checking"
    )
}