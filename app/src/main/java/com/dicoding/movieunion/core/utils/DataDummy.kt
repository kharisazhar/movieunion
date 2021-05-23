package com.dicoding.movieunion.core.utils

import com.dicoding.movieunion.feature.detail_movie.domain.entities.*
import com.dicoding.movieunion.feature.movie.domain.entities.MovieEntity
import com.dicoding.movieunion.feature.movie.domain.entities.MovieResult
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowEntity
import com.dicoding.movieunion.feature.movie.domain.entities.TVShowResult

object DataDummy {
    fun generateDummyMovie(): MovieEntity {
        return MovieEntity(
            page = 0,
            movieResults = listOf(
                MovieResult(
                    adult = false,
                    backdropPath = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                    genreIds = listOf(
                        28,
                        14,
                        12,
                        878
                    ),
                    id = 460465,
                    originalLanguage = "en",
                    originalTitle = "Mortal Kombat",
                    overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    popularity = 5817.001,
                    posterPath = "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                    releaseDate = "2021-04-07",
                    title = "Mortal Kombat",
                    video = false,
                    voteAverage = 7.7,
                    voteCount = 2266,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                    genreIds = listOf(
                        28,
                        12,
                        53,
                        10752
                    ),
                    id = 567189,
                    originalLanguage = "en",
                    originalTitle = "Tom Clancy's Without Remorse",
                    overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                    popularity = 4266.181,
                    posterPath = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                    releaseDate = "2021-04-29",
                    title = "Tom Clancy's Without Remorse",
                    video = false,
                    voteAverage = 7.3,
                    voteCount = 696,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                    genreIds = listOf(
                        878,
                        28,
                        18
                    ),
                    id = 399566,
                    originalLanguage = "en",
                    originalTitle = "Godzilla vs. Kong",
                    overview = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                    popularity = 3608.866,
                    posterPath = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                    releaseDate = "2021-03-24",
                    title = "Godzilla vs. Kong",
                    video = false,
                    voteAverage = 8.1,
                    voteCount = 5373,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/mYM8x2Atv4MaLulaV0KVJWI1Djv.jpg",
                    genreIds = listOf(
                        28,
                        80,
                        53
                    ),
                    id = 804435,
                    originalLanguage = "en",
                    originalTitle = "Vanquish",
                    overview = "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                    popularity = 3156.355,
                    posterPath = "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                    releaseDate = "2021-04-16",
                    title = "Vanquish",
                    video = false,
                    voteAverage = 6.4,
                    voteCount = 69,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg\"",
                    genreIds = listOf(
                        28,
                        53,
                        80
                    ),
                    id = 615457,
                    originalLanguage = "en",
                    originalTitle = "Nobody",
                    overview = "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                    popularity = 2993.014,
                    posterPath = "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                    releaseDate = "2021-03-26",
                    title = "Nobody",
                    video = false,
                    voteAverage = 8.5,
                    voteCount = 1297,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                    genreIds = listOf(
                        28,
                        12,
                        14,
                        878
                    ),
                    id = 791373,
                    originalLanguage = "en",
                    originalTitle = "Zack Snyder's Justice League",
                    overview = "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                    popularity = 1992.158,
                    posterPath = "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                    releaseDate = "2021-03-18",
                    title = "Zack Snyder's Justice League",
                    video = false,
                    voteAverage = 8.5,
                    voteCount = 5358,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
                    genreIds = listOf(
                        28,
                        12,
                        35,
                        14
                    ),
                    id = 615678,
                    originalLanguage = "en",
                    originalTitle = "Thunder Force",
                    overview = "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                    popularity = 1970.51,
                    posterPath = "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                    releaseDate = "2021-04-09",
                    title = "Thunder Force",
                    video = false,
                    voteAverage = 5.8,
                    voteCount = 539,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/xPpXYnCWfjkt3zzE0dpCNME1pXF.jpg",
                    genreIds = listOf(
                        16,
                        28,
                        12,
                        14,
                        18
                    ),
                    id = 635302,
                    originalLanguage = "ja",
                    originalTitle = "劇場版「鬼滅の刃」無限列車編",
                    overview = "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                    popularity = 1775.961,
                    posterPath = "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                    releaseDate = "2020-10-16",
                    title = "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                    video = false,
                    voteAverage = 8.4,
                    voteCount = 882,
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/lHhc60NXYzswU4TvKSo45nY9Jzs.jpg",
                    genreIds = listOf(
                        16,
                        35,
                        10751,
                        12
                    ),
                    id = 726684,
                    originalLanguage = "fr",
                    originalTitle = "Miraculous World Shanghai, la légende de Ladydragon",
                    overview = "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                    popularity = 1632.634,
                    posterPath = "/msI5a9TPnepx47JUb2vl88hb80R.jpg",
                    releaseDate = "2021-04-04",
                    title = "Miraculous World: Shanghai – The Legend of Ladydragon",
                    video = false,
                    voteAverage = 7.8,
                    voteCount = 274,
                ), MovieResult(
                    adult = false,
                    backdropPath = "/5Zv5KmgZzdIvXz2KC3n0MyecSNL.jpg",
                    genreIds = listOf(
                        28,
                        53,
                        80
                    ),
                    id = 634528,
                    originalLanguage = "en",
                    originalTitle = "The Marksman",
                    overview = "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                    popularity = 1484.158,
                    posterPath = "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                    releaseDate = "2021-01-15",
                    title = "The Marksman",
                    video = false,
                    voteAverage = 7.4,
                    voteCount = 421,
                )
            ),
            totalPages = 0,
            totalResults = 0
        )
    }

    fun generateDummyTVSHow(): TVShowEntity {
        return TVShowEntity(
            page = 1,
            tvShowResult = listOf(
//                TVShowResult(
//                    backdropPath =,
//                    firstAirDate =,
//                    genreIds = listOf(
//
//                    ),
//                    id =,
//                    name =,
//                    originCountry = listOf(),
//                    originalLanguage =,
//                    originalName =,
//                    overview =,
//                    popularity =,
//                    posterPath =,
//                    voteAverage =,
//                    voteCount =,
//                )
                TVShowResult(
                    backdropPath = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                    firstAirDate = "2021-03-19",
                    genreIds = listOf(
                        10765,
                        10759,
                        18,
                        10768
                    ),
                    id = 88396,
                    name = "The Falcon and the Winter Soldier",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "The Falcon and the Winter Soldier",
                    overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                    popularity = 1013.58,
                    posterPath = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                    voteAverage = 7.9,
                    voteCount = 5455,
                ),
                TVShowResult(
                    backdropPath = "/zlXPNnnUlyg6KyvvjGd2ZxG6Tnw.jpg\"",
                    firstAirDate = "2017-09-25",
                    genreIds = listOf(
                        18
                    ),
                    id = 71712,
                    name = "The Good Doctor",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "The Good Doctor",
                    overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                    popularity = 870.23,
                    posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                    voteAverage = 8.6,
                    voteCount = 8357,
                ),
                TVShowResult(
                    backdropPath = "/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg",
                    firstAirDate = "2014-10-07",
                    genreIds = listOf(
                        18,
                        10765
                    ),
                    id = 60735,
                    name = "The Flash",
                    originCountry = listOf(
                        "US"
                    ),
                    originalLanguage = "en",
                    originalName = "The Flash",
                    overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    popularity = 879.932,
                    posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    voteAverage = 7.7,
                    voteCount = 7585,
                ),
                TVShowResult(
                    backdropPath = "/Wu8kh7oyvaIfkNyMJyJHCamh5L.jpg",
                    firstAirDate = "2020-12-04",
                    genreIds = listOf(
                        18
                    ),
                    id = 97180,
                    name = "Selena: The Series",
                    originCountry = listOf(
                        "US"
                    ),
                    originalLanguage = "en",
                    originalName = "Selena: The Series",
                    overview = "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music.",
                    popularity = 571.778,
                    posterPath = "/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
                    voteAverage = 7.5,
                    voteCount = 1305,
                ),
                TVShowResult(
                    backdropPath = "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                    firstAirDate = "2021-03-26",
                    genreIds = listOf(
                        16,
                        10759,
                        18,
                        10765
                    ),
                    id = 95557,
                    name = "Invincible",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "Invincible",
                    overview = "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                    popularity = 845.763,
                    posterPath = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                    voteAverage = 8.9,
                    voteCount = 1579,
                ),
                TVShowResult(
                    backdropPath = "/sjxtIUCWR74yPPcZFfTsToepfWm.jpg",
                    firstAirDate = "2021-05-04",
                    genreIds = listOf(
                        10765,
                        10759,
                        16

                    ),
                    id = 105971,
                    name = "The Bad Batch",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "The Bad Batch",
                    overview = "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
                    popularity = 809.935,
                    posterPath = "/WjQmEWFrOf98nT5aEfUfVYz9N2.jpg",
                    voteAverage = 9.1,
                    voteCount = 144,
                ),
                TVShowResult(
                    backdropPath = "/hNiGqLsiD30C194lci7VYDmciHD.jpg",
                    firstAirDate = "2017-04-26",
                    genreIds = listOf(
                        10765,
                        18
                    ),
                    id = 69478,
                    name = "The Handmaid's Tale",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "The Handmaid's Tale",
                    overview = "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel.",
                    popularity = 544.487,
                    posterPath = "/oIkxqt6ug5zT5ZSUUyc1Iqopf02.jpg",
                    voteAverage = 8.2,
                    voteCount = 1323,
                ),
                TVShowResult(
                    backdropPath = "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                    firstAirDate = "2005-03-27",
                    genreIds = listOf(
                        18
                    ),
                    id = 1416,
                    name = "Grey's Anatomy",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "Grey's Anatomy",
                    overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                    popularity = 622.539,
                    posterPath = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                    voteAverage = 8.2,
                    voteCount = 6027,
                ),
                TVShowResult(
                    backdropPath = "/4YKkS95v9o9c0tBVA46xIn6M1tx.jpg",
                    firstAirDate = "2021-05-07",
                    genreIds = listOf(
                        10765,
                        10759,
                        18
                    ),
                    id = 93484,
                    name = "Jupiter's Legacy",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "Jupiter's Legacy",
                    overview = "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                    popularity = 844.815,
                    posterPath = "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                    voteAverage = 7.5,
                    voteCount = 159,
                ),
                TVShowResult(
                    backdropPath = "/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg",
                    firstAirDate = "2018-04-22",
                    genreIds = listOf(
                        18
                    ),
                    id = 79008,
                    name = "Luis Miguel: The Series",
                    originCountry = listOf("MX"),
                    originalLanguage = "es",
                    originalName = "Luis Miguel: The Series",
                    overview = "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                    popularity = 481.296,
                    posterPath = "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                    voteAverage = 8.1,
                    voteCount = 395,
                )
            ),
            totalPages = 500,
            totalResults = 10000,
        )
    }

    fun generateDummyMovieDetail(): MovieDetailEntity {
        return MovieDetailEntity(
            adult = false,
            backdropPath = "/6ELCZlTA5lGUops70hKdB83WJxH.jpg\"",
            belongsToCollection = "",
            budget = 20000000,
            genres = listOf(
                Genre(28, "Action"),
                Genre(14, "Fantasy"),
                Genre(12, "Adventure"),
            ),
            homepage = "https://www.mortalkombatmovie.net",
            id = 460465,
            imdbId = "tt0293429",
            originalLanguage = "en",
            originalTitle = "Mortal Kombat",
            overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            popularity = 2437.17,
            posterPath = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
            productionCompanies = listOf(
                ProductionCompany(
                    76907,
                    "/wChlWsVgwSd4ZWxTIm8PTEcaESz.png",
                    "Atomic Monster",
                    "US"
                )
            ),
            productionCountries = listOf(ProductionCountry("US", "United States of America")),
            releaseDate = "2021-04-07",
            revenue = 1,
            runtime = 1,
            spokenLanguages = listOf(SpokenLanguage("", "", "")),
            status = "",
            tagline = "",
            title = "",
            video = false,
            voteAverage = 1.0,
            voteCount = 1
        )
    }

    fun generateDummyTVDetail(): TVDetailEntity {
        return TVDetailEntity(
            backdropPath = "",
            createdBy = listOf(CreatedBy("", 1, 1, "", "")),
            episodeRunTime = listOf(1, 1),
            firstAirDate = "",
            genres = listOf(TVGenre(1, "ac")),
            homepage = "",
            id = 1,
            inProduction = false,
            languages = listOf("en"),
            lastAirDate = "",
            lastEpisodeToAir = LastEpisodeToAir("1", 1, 1, "", "", "", 1, "", 1.0, 1),
            name = "",
            networks = listOf(Network(1, "", "", "")),
            nextEpisodeToAir = "",
            numberOfEpisodes = 1,
            numberOfSeasons = 1,
            originCountry = listOf("en"),
            originalLanguage = "en",
            originalName = "",
            overview = "s",
            popularity = 1.0,
            posterPath = "",
            voteAverage = 2.0,
            voteCount = 1
        )
    }
}