Feature:Gmail login
Scenario:validate gmail title
Given launch gmail site
Then title is "Gmail" for home page
And close site

Scenario:validate forgot email link
Given launch gmail site
When click forgot email link
Then phone number or email is displayed
And close site

