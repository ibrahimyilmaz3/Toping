package com.example.toping.`object`

import com.example.toping.model.Route

object Route {
    val route = ArrayList<Route>()
    var route2 = ""

    var navRoute = 0

    init {
        route.add(Route("Başlangıç Noktası",null))
        route.add(Route("Varış Noktası",null))
    }
}