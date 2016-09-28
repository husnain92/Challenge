1. What is the major difference between an  abstract  class and an  interface?

Ans: Abstract class does not support multiple inheritance and on other hand Interfaces support multiple inheritance. Also  
Abstract class can have static methods, main methods and constructor, well on other hand Interface can't have static  
methods, main methods and constructor.

2.Why is Java 7’s class inheritance flawed?

Ans: I don't know.

3. What are the major differences between  Activities  and  Fragments?

Ans: An Activity is an application component that provides a screen, with which users can interact in order to do  
something. An Activity may contain 0 or multiple number of fragments based on the screen size. A fragment can be reused in  
multiple activities, so it acts like a reusable component in activities. Fragment is a part of an activity, which  
contributes its own UI to that activity.

4. When using  Fragments , how do you communicate back to their hosting  Activity?

Ans: We use fragments when we want user interface organized so that we can manage complex screens easily as well we can  
divide operations of activity by using different fragments and it improve backstack manipulation. Also we use fragments  
when we want to reuse same screen in multiple activities. Fragments are light weight as compare to activities and better  
suited for apps which support both mobile and tablet.
     We can communicate to host activity by using interface as a call back to host activity and send data or any message  
to host activity.

5. Can you make an entire app without ever using  Fragments ? Why or why not?
Are there any special cases when you absolutely have to use or should use
Fragments?

Ans: Yes we can make app without using fragments but it is not a smart approach. When we develop large apps with only  
activities it may effect performance of application. Fragments are light weight as compare to activities and better suited  
for apps which support both mobile and tablet.  Fragments are reusable and as such they are the best place for your UI and  
logic if there is any chance that you may have to use the same layout/logic elsewhere.  

6. What makes an  AsyncTask  such an annoyance to Android developers? Detail
some of the issues with  AsyncTask , and how to potentially solve them.

Ans: Asynctask work fine until you rotate screen. Screen rotation annoyance for developers because when an app is  
rotated, the entire Activity is destroyed and recreated. When the Activity is restarted, your AsyncTask’s reference to the  
Activity is invalid, so onPostExecute() will have no effect on the new Activity. This can be confusing if you are  
implicitly referencing the current Activity by having AsyncTask as an inner class of the Activity. The usual solution to  
this problem is to hold onto a reference to AsyncTask that lasts between configuration changes, which updates the target  
Activity as it restarts.

Suppose you’ve got a search query that runs in an AsyncTask. The user may be able to change the search parameters while the  
AsyncTask is running, so you call AsyncTask.cancel() and then fire up a new AsyncTask for the next query. This seems to  
work until you check the logs and realize that your AsyncTasks all ran till completion, regardless of whether you called  
cancel() or not. There are two simple solutions that cover most situations: Either check AsyncTask.isCancelled() on a  
regular basis during your long-running operation, or keep your Thread interruptible. Either way, when you call  
AsyncTask.cancel() these methods should prevent your operation from running longer than necessary.
