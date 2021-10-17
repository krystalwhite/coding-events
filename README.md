# coding-events
Purpose of App: The Coding Events App provides and interface for users to see and create coding opportunities (such as conferences, meetups, etc.), sorted by event category types and focus areas (tags).

Current App State: The app is rather interactive. The user can create events, event categories, and interests; can sort and display by each of those critera; can pull from and update a SQL database that stores all the information of the coding events app.

Ways to Improve: A way to improve the app would be to include a Person class, with fields for id (int), name (string), email (string), interests/tags (tags), location (string), and events the person is interested in (ArrayList of Events), two constructors (one to initialize some of the fields, another as a no-arg), and the standard getters, setters, equals, and toString. The Person class would have to be in a many-to-many relationship with the Events class, so additional coding infrastucture would be needed for that relationship to exist, both in the coding and the SQL side.
