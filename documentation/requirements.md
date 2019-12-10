# Business definitions

## Summary

ToWord app is a simple wishlist tracker for movies/TV series, books and other activities. While there are sophisticated alternatives for each category (TV Time , Goodreads, LiveLib, etc.), ToWord provides a simpler way to track personal lists for things to watch, read or do (for example play board or video games) in a clean interface with distinct focus.

## User stories
|Version |Story name |Story |
|:-------|:----------|:-----|
|1.0     |Sign in    |As an anonymous user I want to see Google account selection dialog with accounts on my device. Once I pick an account to use in the app, I want to navigate to main app interface with to watch/to read/to do lists. If I didn't use the app before, my account should be created without any extra prompts.|
|1.0     |Saving data|As a signed in user I want that all the data I enter is saved in the cloud automatically. I should also be able to create or edit data without internet connection. My data is personal but not private (no need for encryption).|
|1.0     |Main lists |As a signed in user I want to see main app screen with possibility to switch between three lists: to watch, to read, to do. Every list consists of items with check boxes sorted by changed timestamp (new on top), unchecked items first, checked below. Every list screen should contain a button to add a new item.|
|1.0     |Checking items|As a signed in user whenever I press on the checkbox next to a list item, popup dialog should be shown with three options: recommend, would not recommend, not sure. Selecting one of the options will confirm the item selection. Item can be unchecked without any confirmation, checking it again will make the confirmation dialog reappear. Checked items in the list should indicate the recommendation status.|
|1.0     |Create/edit item|As a signed in user when I click on new item button or click on the list item I should see an edit screen which varies depending on the item type. Edit movie: one text input (__title-year__); edit book: two optional text input fields (__title, author__); edit todo: one text input field and preset buttons which prepend text to the input - _play video game, play board game, go to._|
|1.0     |Movie lookup   |As a signed in user I want to be able to look up entered movie or TV series in an online database from the create/edit screen. I then should be presented with a possible matches list. Clicking any item in the list should open a relevant webpage in an external browser.|
|1.0     |Book lookup   |As a signed in user I want to be able to look up entered book in an online database from the create/edit book screen. I then should be presented with a possible matches list. Clicking any item in the list should open a relevant webpage in an external browser.|
|1.0     |Settings      |As a signed in user I want to see a settings button on the main lists screen. Settings screen should contain dark mode switch (off by default) and a logout button. Logout button should erase all local data; cloud copy should remain).|
|2.0     |Sharing   |As a signed in user I want to be able to get a share link for my profile. Person receiving the share link should be able to see all my entered data if they have ToWord app installed but should not be able to edit it.| 


