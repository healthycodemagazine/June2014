module.exports = function(grunt) {
 	grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        coffee: {
			compile: {
				files: {
					"dist/simple_validator.js" : "src/SimpleValidator.coffee",
					"spec/simple_validator_spec.js" : "spec/SimpleValidatorSpec.coffee"
				}
			}
		},
		jasmine: {
			pivotal: {
				src: ["dist/**/*.js"],
				options: {
					specs: 'spec/*_spec.js'
				}
			}
		},
		uglify: {
			my_target: {
				src: ["dist/simple_validator.js"],
				dest: "dist/simple_validator.min.js"
			}
		},
    });
    grunt.loadNpmTasks("grunt-contrib-coffee");
    grunt.loadNpmTasks("grunt-contrib-jasmine");
    grunt.loadNpmTasks("grunt-contrib-uglify");
 	grunt.registerTask("default", ["coffee","jasmine","uglify"]);
};