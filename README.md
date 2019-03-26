# FaizDialer
![](https://github.com/bioburn/FaizDialer/blob/master/app/src/main/res/drawable/smartbrain.png?raw=true)
Made this because my Android SDK is rusty.

Makes sound effects from Kamen Rider Faiz

<br/>
This android application was hacked together to demonstrate 
Activities
Lifecycles
constraint layouts
View Pagers, ViewPagerAdapters
Recycler Views, RecyclerViewAdapters
Fragments
Communicating between fragments
Requesting runtime permissions
Action Intents

<br/>
<br/>
<H1>Remarks</H1>
Many of the ui elements had their display texts set from the Android Studio UI and were not set to point at strings in the 
Strings resource xml. At the time, I made all the buttons at once and needed the text on there quickly in order to test. Moving forward,
All static text should be defined in the Strings resource xml and referenced in the view xml

<br/>
<br/>
The main activity for this dialer was originally a single main activity (MainActivity.java)
I converted this activity into a fragment in order to have swiping tabs (view pager)
<br/>
<br/>
Communication between fragments could have been handled better and more properly.
The contacts recycler view does feature the implemented listener interface in the main activity, which updates the dialer fragment with the selected contact number by passing it the value received from the contacts fragment.


<br/>
<br/>
Transactions and adding to the backstack were unnecessary for this application

<br/>
<br/>
At the time of writing this readme, the ids of the views are suboptimal for human readability and will need to be changed. Everywhere.

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


