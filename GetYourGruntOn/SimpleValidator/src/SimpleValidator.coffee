class window.SimpleValidator

  validateNumeric:(input)->
    return false if input is null or input is undefined
    !isNaN(parseFloat(input)) and isFinite(input)

  validateLength:(input, minLength, maxLength)->
    return false if input is null or input is undefined
    input = "" + input
    input.length > minLength and input.length < maxLength

  validateEmail:(input)->
    return false if input is null or input is undefined
    re = /@/
    re.test(input)
