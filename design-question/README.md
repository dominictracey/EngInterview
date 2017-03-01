First pass at a design exercise:

## Design Exercise

Assume you have a map like the maps you see throughout our sites. As an example, let's use the one on the [area page for Rocky Mountain National Park](https://www.hikingproject.com/directory/8007421).

This map:

1. Dynamically loads trails, symbols, photos, REI store locations, and gems.
2. Supports 3 basic zoom levels: identical grouped bubbles at the furthest zoom, grouped bubbles by trail difficulty at the middle zoom, and full trail details at the closest zoom.
3. Loads data within a given [bounding box](http://wiki.openstreetmap.org/wiki/Bounding_Box), and loads data from adjacent bounding boxes as the user scrolls around.

That's a pretty good amount of data. How would you design the map loading process to be as efficient as possible, while still maintaing a snappy-feeling experience for users?

There are a ton of variables here, and we're not looking for code in this answer, nor are worried about the process of actually drawing the map lines. What we are intersted in are things like:

1. What's the basic signature of the endpoint(s) you're using to load the map data?
2. What are the pluses and minuses of the endpoint(s) you chose, in terms of both server performance, front-end performance, and user experience?
3. What assumptions are you making about which performance lags are more acceptable than others?

Please check-in a text or markdown document in this folder, no more than about a page long, that runs us through your thought process and a provides a high-level overview of the process and endpoint(s) you'd use to load the map data.
