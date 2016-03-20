The UI is composed of the following parts:

+ Main Screen: A predifined search categories for different cities.
+ A Search Dialog: Currently supporting the search by destination, start date and end date.
+ A result screen: Here you will get the list of cars found, if no errors were present.
+ A drawer: Currently not implemented.

Activities

+ MainActivity: Is the main screen
+ ResultListActivity: Activity holding the search result

Model Package
Contains all model required for the app.
The main model is the HotWireResult, which will hold the same object retrived by the request

Communication package
Contains the Interface API to make request to HotWire.

The RequestFactory was implemented to be used with Retrofit.


Adapters Package
It contains the Adapters for the Main screen and result screen.

Task package
Contains the task to execute the request to HotWire and deliver the result to the ResultListActivity

Util package
Contains the HotWireResultParser which gets the JSON string and converts it to HotWireResult.



NOTE:
- There are still validations to handle.
- I need to add more information to the result screen. Currently is showing only the price and a default screen, but more info can be added easily.
- I need to add a onItemClickListener on the search result for an individual view.
- The HotWireResult needs more data to be parsed.
