(function() {
  window.SimpleValidator = (function() {
    function SimpleValidator() {}

    SimpleValidator.prototype.validateNumeric = function(input) {
      if (input === null || input === void 0) {
        return false;
      }
      return !isNaN(parseFloat(input)) && isFinite(input);
    };

    SimpleValidator.prototype.validateLength = function(input, minLength, maxLength) {
      if (input === null || input === void 0) {
        return false;
      }
      input = "" + input;
      return input.length > minLength && input.length < maxLength;
    };

    SimpleValidator.prototype.validateEmail = function(input) {
      var re;
      if (input === null || input === void 0) {
        return false;
      }
      re = /@/;
      return re.test(input);
    };

    return SimpleValidator;

  })();

}).call(this);
