package com.moviereel.data.api.model.movie.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.moviereel.data.api.model.BaseResponse
import com.moviereel.data.db.entities.movie.MovieNPEntity

/**
 * @author lusinabrian on 01/04/17
 * *
 * @Notes Response object for upcoming movies. This will get upcoming movies for the next 1 month
 * * An example response
 * * {
 * * "page": 1,
 * * "results":[
 * *  {
 * *  "poster_path": "/qwoGfcg6YUS55nUweKGujHE54Wy.jpg",
 * *  "adult": false,
 * *  "overview": "Captain Jack Sparrow is pursued by an old rival, Captain Salazar, who along with his crew of ghost pirates has escaped from the Devil's Triangle, and is determined to kill every pirate at sea. Jack seeks the Trident of Poseidon, a powerful artifact that grants its possessor total control over the seas, in order to defeat Salazar.",
 * *  "release_date": "2017-05-24",
 * *  "genre_ids": [ 28, 12, 35, 14 ],
 * *  "id": 166426,
 * *  "original_title": "Pirates of the Caribbean: Dead Men Tell No Tales",
 * *  "original_language": "en",
 * *  "title": "Pirates of the Caribbean: Dead Men Tell No Tales",
 * *  "backdrop_path": "/3DVKG54lqYbdh8RNylXeCf4MBPw.jpg",
 * *  "popularity": 19.733165,
 * *  "vote_count": 49,
 * *  "video": false,
 * *  "vote_average": 0
 * *  },
 * *  ....
 * * ]
 * * "dates": {
 * *  "maximum": "2017-06-12",
 * *  "minimum": "2017-05-22"
 * *  },
 * * "total_pages": 8,
 * * "total_results": 145
 * * }
 * *
 */
class MovieUpcomingResponse : BaseResponse() {

    @Expose
    @SerializedName("dates")
    var datesResponse: DatesResponse? = null

    @Expose
    @SerializedName("results")
    var results: List<MovieNPEntity>? = null
}
