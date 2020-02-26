# Business requirements

## Summary

ToWord app is a simple wish-list tracker for movies/TV series, books and other activities. While there
are more sophisticated alternatives for each category (TV Time , Goodreads, LiveLib, etc.),
ToWord provides a simpler way to track personal lists for things to watch, read or do
(for example play board or video games) in a clean interface with distinct focus.

## Requirements

Project requirements are outlined in the form of user stories in the following section.
Technical requirements are defined in the [separate document](./technical_requirements.md).

### User stories
|Version |Story name      |Story |
|:-------|:---------------|:-----|
|1.0     |Saving data     |As an app user I want that all the data I enter is saved in the
cloud automatically. I should also be able to create or edit data without internet connection.
My data is personal but not private (no need for encryption).|

|1.0     |Main lists      |As an app user I want to see main app screen with possibility to
switch between three lists: to watch, to read, to do. Every list consists of items with check boxes
sorted by changed timestamp (new on top), unchecked items first, checked below. Every list screen
should contain a button to add a new item.|

|1.0     |Checking items  |As an app user whenever I press on the checkbox next to a list item,
popup dialog should be shown with three options: recommend, would not recommend, not sure.
Selecting one of the options will confirm the item selection. Item can be unchecked without any
confirmation, checking it again will make the confirmation dialog reappear. Checked items in the
list should indicate the recommendation status.|

|1.0     |Create/edit item|As an app when I click on new item button or click on the list
item I should see an edit screen which varies depending on the item type. Edit movie: one text input
(__title-year__); edit book: two optional text input fields (__title, author__); edit to do: one text
input field and preset buttons which prepend text to the input - _play video game,
play board game, go to._|

|1.0     |Delete item     |As an app user I want to be able to delete item from the item edit
screen or by swiping item left or right in the list. No confirmation dialog is needed,
but snack bar with "undo" action should be shown.|

|1.0     |Settings        |As an app user I want to see a settings button on the main lists
screen. Settings screen should contain dark mode switch (off by default) and a logout button.
Logout button should erase all local data; cloud copy should remain.|

|2.0     |Movie lookup    |As an app user I want to be able to look up entered movie or
TV series in an online database from the create/edit screen. I then should be presented with a
possible matches list. Clicking any item in the list should open a relevant webpage in
the external browser.|

|2.0     |Book lookup     |As an app user I want to be able to look up entered book in an
online database from the create/edit book screen. I then should be presented with a possible matches
list. Clicking any item in the list should open a relevant webpage in the external browser.|

## Design wireframes

