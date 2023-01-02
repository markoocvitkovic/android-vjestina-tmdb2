package agency.five.codebase.android.movieapp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.material.Text
import agency.five.codebase.android.movieapp.mock.MoviesMock.getMovieDetails
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private const val PERCENTAGE_FACTOR = 10f
private const val STARTING_ANGLE = -90f
private const val SCORE_FORMAT = "%.1f"

@Composable
fun ProgressBar(
    modifier: Modifier,
    score: Float
) {
    Box(contentAlignment = Alignment.Center,
        modifier = modifier) {
        Canvas( modifier = Modifier
            .padding(MaterialTheme.spacing.extraSmall)
            .fillMaxSize()
        ) {
            drawArc(
                color = Color(100, 300, 100),
                alpha = 0.2f,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 5.dp.toPx())
            )
            drawArc(
                color = Color(61, 235, 75),
                startAngle = 270f,
                sweepAngle = score * 360f,
                useCenter = false,
                style = Stroke(width = 5.dp.toPx())
            )
        }
        Text(
            text = SCORE_FORMAT.format(score * PERCENTAGE_FACTOR).toString(),
            fontSize = 15.sp,
            color = Color.Black,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewUserScoreProgressBar() {
    val score: Float = getMovieDetails().voteAverage
    ProgressBar(score = 0.698f, modifier = Modifier)
}
