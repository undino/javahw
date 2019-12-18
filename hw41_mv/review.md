# Review

В файле index3.html ошибки:

```text
    Error: An img element must have an alt attribute, except under certain conditions. For details, consult guidance on providing text alternatives for images.

    From line 115, column 9; to line 115, column 36

    >↩        <img src="img/username.png"><input

    Error: Bad value for attribute id on element select: An ID must not be the empty string.

    From line 125, column 9; to line 125, column 46

    >↩        <select class="sel" name="male" id="">↩     

    Warning: The date input type is not supported in all browsers. Please be sure to test, and consider using a polyfill.

    From line 129, column 9; to line 129, column 27

    >↩        <input type="date">↩    <
```

В файле index2.html ошибки:

```text

    Error: The label element may contain at most one button, input, meter, output, progress, select, or textarea descendant.

    From line 195, column 9; to line 196, column 61

    >↩        <input class="inp" type="text" placeholder="1234 5678 9012 3456" required↩               pattern="[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}">↩     

    Warning: label element with multiple labelable descendants.

    From line 192, column 5; to line 192, column 11

    et">↩↩    <label>Input 

    Error: The label element may contain at most one button, input, meter, output, progress, select, or textarea descendant.

    From line 197, column 9; to line 198, column 61

    >↩        <input class="inp" type="text" placeholder="1234 5678 9012 3456" required↩               pattern="[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}">↩    <

    Warning: label element with multiple labelable descendants.

    From line 192, column 5; to line 192, column 11

    et">↩↩    <label>Input 

    Error: Element div not allowed as child of element label in this context. (Suppressing further errors from this subtree.)

    From line 205, column 9; to line 205, column 36

    >↩        <div class="checkbox__text">Subscr

    Contexts in which element div may be used:
        Where flow content is expected.
        As a child of a dl element.
    Content model for element label:
        Phrasing content, but with no descendant labelable elements unless it is the element's labeled control, and no descendant label elements.

    Error: The label element may contain at most one button, input, meter, output, progress, select, or textarea descendant.

    From line 212, column 15; to line 212, column 48

        Woman <input type='radio' name="gender">↩    <

    Warning: label element with multiple labelable descendants.

    From line 210, column 5; to line 210, column 11

    <br>↩↩    <label>Gender

    Error: Bad value for attribute for on element label: An ID must not be the empty string.

    From line 228, column 5; to line 228, column 18

    <br>↩↩    <label for="">Text a

    Error: Bad value for attribute name on element textarea: Must not be empty.

    From line 230, column 9; to line 230, column 63

    >↩        <textarea class="s8" name="" id="" cols="30" rows="10"></text

    Error: Bad value for attribute id on element textarea: An ID must not be the empty string.

    From line 230, column 9; to line 230, column 63

    >↩        <textarea class="s8" name="" id="" cols="30" rows="10"></text

    Error: The value of the for attribute of the label element must be the ID of a non-hidden form control.

    From line 228, column 5; to line 228, column 18

    <br>↩↩    <label for="">Text a
```