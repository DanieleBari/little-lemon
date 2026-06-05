package com.littlelemon.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.littlelemon.littlelemon.R

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile",
        modifier = modifier
            .size(48.dp)
            .clickable { onClick() }
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
@Preview(showBackground = true)
fun ProfileIconPreview(){
    ProfileIcon(onClick = {})
}
