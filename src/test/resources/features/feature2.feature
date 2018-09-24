Feature:Gmail login
Scenario Outline:validate userid field
Given launch gmail site
When enter userid as "<x>" value
And click next button
Then validate userid depends on criteria "<y>" value
And close site
Examples:
|     x       |      y       |
|siv203gec10  |   valid      |
|siv203gec    |  invalid     |
|             |  invalid     |

Scenario Outline:validate password field
Given launch gmail site
When enter userid as "siv203gec10" value
And click next button
When enter password as "<x>" value
And click password Next button
Then validate password depends on criteria "<y>" value
And close site
Examples:
|     x       |      y       |
|9441437637   |   valid      |
|siv203       |  invalid     |
|             |  invalid     |
