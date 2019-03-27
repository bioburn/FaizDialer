# FaizDialer
![](https://github.com/bioburn/FaizDialer/blob/master/app/src/main/res/drawable/smartbrain.png?raw=true)
Made this because my Android Development is rusty.

Makes sound effects from Kamen Rider Faiz

<br/>
This android application was hacked together to demonstrate
<br/>
Activities
<br/>
Lifecycles
<br/>
constraint layouts
<br/>
View Pagers, ViewPagerAdapters
<br/>
Recycler Views, RecyclerViewAdapters
<br/>
Fragments
<br/>
Communicating between fragments
<br/>
Requesting runtime permissions
<br/>
Action Intents

<br/>
<br/>
<H1>Remarks</H1>
Many of the ui elements had their display texts set from the Android Studio UI and were not set to point at strings in the 
Strings resource xml. At the time, I made all the buttons at once and needed the text on there quickly in order to test. Moving forward,
All static text should be defined in the Strings resource xml and referenced in the view xml

<br/>
<br/>
All extra parameter names should be defined as static strings at the top of the class instead of string literals

<br/>
<br/>
Perhaps the arraylist of contacts should be staticly defined in the activity only and accessible by the fragments instead of keeping a local copy in the fragment as well.

<br/>
<br/>
I have a habit of making EVERYTHING public. Should make methods and variables private to prevent unintended behavior by design

<br/>
<br/>
The main activity for this dialer was originally a single main activity (MainActivity.java)
I converted this activity into a fragment in order to have swiping tabs (view pager)
<br/>
<br/>
Communication between fragments could have been handled better and more properly.
The contacts recycler view does feature the implemented listener interface in the main activity, which updates the dialer fragment with the selected contact number by passing it the value received from the contacts fragment.
However, calling notifydatasetchanged() from addcontact was cheating. It works because there was only one expected behavior from design.

For multiple behaviors, define an interface in the fragment and implement it in the activity. Trigger callback in fragment and activity will execute a specific behavior.
<br/>
**Update - defined interface listener method in addcontact, implemented method in activity, moved existing logic to implementation of listener

<br/>
<H4>Note to self</H4>In the implementation of listener,  use fragment manager transactions to update the view
Can also get reference to the fragment and call a method defined within it
https://stackoverflow.com/questions/10903077/calling-a-fragment-method-from-a-parent-activity
<br/>
But, this only works if you have a fragment view in your layout. This does not happen with a viewpager.
https://learnpainless.com/android/how-to-get-fragment-from-viewpager-android
<br/>
Also, fragments in a viewpager are paused/destroyed if they are not the neighbor of the currently displayed fragment



<br/>
<br/>
Transactions and adding to the backstack were unnecessary for this application

<br/>
<br/>
At the time of writing this readme, the ids of the views are suboptimal for human readability and will need to be changed. Everywhere.
<br/>
**Update - renamed views to be more accurate, better readability

<br/>
<br/>
Discovered permissions bugs. Fixed and app should always work if user gives permissions.

<br/>
<br/>
Coming soon:
<br/>
Resources.txt - list of resources used

<H1>Main Screen Tab 1</H1>

<img src="https://github.com/bioburn/FaizDialer/blob/master/Main.png?raw=true" width="400" height="790">

When entering a number, a matching contact suggestion will appear in the top text view
<br/>
Tapping this view will replace your current number to dial with the suggestion

<br/>
Hitting Enter will make the call by starting a new Action Dial intent

<br/>

Swiping left puts the Contacts and AddContacts fragments into view
<img src="https://github.com/bioburn/FaizDialer/blob/master/Swipe1.png?raw=true" width="400" height="790">

<img src="https://github.com/bioburn/FaizDialer/blob/master/Swipe2.png?raw=true" width="400" height="790">

<img src="https://github.com/bioburn/FaizDialer/blob/master/AddContact.png?raw=true" height="790">


<br/>
<br/>


