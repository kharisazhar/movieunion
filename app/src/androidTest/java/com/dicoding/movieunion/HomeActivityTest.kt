package com.dicoding.movieunion

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.movieunion.core.utils.DataDummy
import com.dicoding.movieunion.feature.movie.presentation.ui.HomeActivity
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val moviesEntities = DataDummy.generateDummyMovie()
    private val tvShowEntities = DataDummy.generateDummyTVSHow()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun assertHomePageLayout() {
        onView(withId(R.id.appsLogo)).check(matches(isDisplayed()))
        onView(withId(R.id.tvPopularMovieSection)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTVShowSection)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowMoreMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowMoreTVSHow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTVShow)).check(matches(isDisplayed()))
    }

    @Test
    fun assertPopularMovie() {
        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                moviesEntities.movieResults.size
            )
        )

        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )

        checkDetailItemMovie()

        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun assertTVShow() {
        onView(withId(R.id.rvTVShow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                tvShowEntities.tvShowResult.size
            )
        )

        onView(withId(R.id.rvTVShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )

        checkDetailItemTVSHow()
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun assertItemShowMore() {
        onView(withId(R.id.tvShowMoreMovie)).perform(ViewActions.click())
        onView(withId(R.id.rvMovieSeeMore)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        checkDetailItemMovie()
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.tvShowMoreTVSHow)).perform(ViewActions.click())
        onView(withId(R.id.rvMovieSeeMore)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        checkDetailItemTVSHow()
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    private fun checkDetailItemMovie() {
        onView(withId(R.id.imgBackdropPath)).check(matches(isDisplayed()))
        onView(withId(R.id.ratingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(moviesEntities.movieResults[0].title)))
        onView(withId(R.id.tvOverview)).check(matches(withText(moviesEntities.movieResults[0].overview)))
        onView(withId(R.id.tvRating)).check(matches(withText("${moviesEntities.movieResults[0].voteAverage / 2}")))
    }

    private fun checkDetailItemTVSHow() {
        onView(withId(R.id.imgBackdropPath)).check(matches(isDisplayed()))
        onView(withId(R.id.ratingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(tvShowEntities.tvShowResult[0].name)))
        onView(withId(R.id.tvOverview)).check(matches(withText(tvShowEntities.tvShowResult[0].overview)))
        onView(withId(R.id.tvRating)).check(matches(withText("${tvShowEntities.tvShowResult[0].voteAverage / 2}")))
    }
}