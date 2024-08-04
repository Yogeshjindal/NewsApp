package com.example.newsapp.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.newsapp.R
import com.example.newsapp.presentation.onboarding.Dimens

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    ).value

    this.background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}

@Composable
fun ArticleCardShimmerEffect(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(Dimens.ExtraSmallPadding)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(Dimens.ArticleCardSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Dimens.ExtraSmallPadding)
                .height(Dimens.ArticleCardSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(15.dp)
                    .shimmerEffect()
            )
        }
    }
}
