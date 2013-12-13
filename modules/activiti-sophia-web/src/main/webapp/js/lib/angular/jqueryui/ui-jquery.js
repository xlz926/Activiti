/*global angular:true $:true*/
'use strict';
(function () {

    /**
     *
     * @return {String}
     */
    String.prototype.capitalize = function () {
        return this.charAt(0).toUpperCase() + this.slice(1);
    }

    /**
     * Assign options to the plugin and setup watcher to get track of the modifications
     * @param scope The angular.Scope
     * @param options Current options
     * @param element The element to be used with the plugin
     * @param optionNames The name of the options to be assigned
     * @param pluginName The name of the plugin to be called when a options is changed on the scope
     */
    var assignOptions = function (scope, options, element, optionNames, pluginName) {
        $(optionNames).each(function (i, optionName) {
            options[optionName] = scope[optionName];
            scope.$watch(optionName, function () {
                $(element)[pluginName]('option', optionName, scope[optionName]);
            });
        });
    };

    /**
     * Assign events to the plugin.
     * @param scope The scope
     * @param options Current options
     * @param eventNames The name of the events to be assigned
     */
    var assignEvents = function (scope, options, eventNames) {
        $(eventNames).each(function (i, eventName) {
            if (scope[eventName] !== undefined) {
                options[eventName] = function (event, ui) {
                    if (angular.isFunction(scope[eventName])) {
                        scope[eventName].apply(null, arguments);
                    }
                }
            }
        });
    }

    /**
     * Get a new scope definition using the patterns for jui-directives.
     * @param eventNames An array containing all event names for the plugin
     * @param optionNames An array containing all option names for the plugin
     * @return {Object} The scope definition object
     */
    var getScopeDefinition = function (eventNames, optionNames) {
        var scopeDefinition = {};

        eventNames.forEach(function (eventName) {
            scopeDefinition[eventName] = '=event' + eventName.capitalize();
        });

        optionNames.forEach(function (optionName) {
            scopeDefinition[optionName] = '=opt' + optionName.toLowerCase().capitalize();
        });

        return scopeDefinition;
    }

    /**
     * Get a default link function that apply the plugin passed on the pluginName argument and
     * invokes assignOptions and assignEvents to control all aspects of the plugin using the
     * AngularJS Scope's $watch mechanism.
     *
     * @param pluginName The plugin name to be injected into the element passed throught the link function
     * @param eventNames An array of event names for the current plugin
     * @param optionNames An array of option names for the current plugin
     * @return {Function} An link function ready to be using on the scope definition
     */
    var getDefaultLinkFunc = function (pluginName, eventNames, optionNames) {
        return function (scope, element, attrs) {
            var options = {};

            assignOptions(scope, options, element, optionNames, pluginName);

            // Assign events to the options hash.
            assignEvents(scope, options, eventNames);

            // Apply the plugin
            $(element)[pluginName](options);
        }
    }

   angular.module('ui.jquery', ['ui.jquery.draggable','ui.jquery.dialog']);

    /**
     * Define a new directive for jQueryUI Draggable.
     */
    angular.module('ui.jquery.draggable', []).directive('draggable', function draggable() {
        var eventNames = [
                'create',
                'start',
                'drag',
                'stop' ],
            optionNames = [
                'disabled',
                'addClasses',
                'appendTo',
                'axis',
                'cancel',
                'connectToSortable',
                'containment',
                'cursor',
                'cursorAt',
                'delay',
                'distance',
                'grid',
                'handle',
                'helper',
                'iframeFix',
                'opacity',
                'refreshPositions',
                'revert',
                'revertDuration',
                'scope',
                'scroll',
                'scrollSensitivity',
                'scrollSpeed',
                'snap',
                'snapMode',
                'snapTolerance',
                'stack',
                'zIndex'
            ];

        return {
            restrict:'A',
            scope:getScopeDefinition(eventNames, optionNames),
            link:getDefaultLinkFunc('draggable', eventNames, optionNames)
        };
    });



    /**
     * Define a new directive for jQueryUI Dropabble.
     *
     * @link http://jqueryui.com/demos/droppable/
     */
    angular.module('ui.jquery.droppable', []).directive('droppable', function juiDroppable() {
        var eventNames = [
                'create',
                'activate',
                'deactivate',
                'over',
                'out'],
            optionNames = [
                'disabled',
                'accept',
                'activeClass',
                'addClasses',
                'greedy',
                'hoverClass',
                'scope',
                'tolerance'];


        return {
            restrict:"A",
            scope:getScopeDefinition(eventNames, optionNames),
            link:getDefaultLinkFunc('droppable', eventNames, optionNames)
        };
    });

    /**
     * Define a directive for jQueryUI Resizable.
     *
     * @link http://jqueryui.com/demos/resizable/
     */
    angular.module('ui.jquery.resizable', []).directive('resizable', function juiResizable() {
        var eventNames = [
                'create',
                'start',
                'resize',
                'stop' ],
            optionNames = [
                'disabled',
                'alsoResize',
                'animate',
                'animateDuration',
                'animateEasing',
                'aspectRatio',
                'autoHide',
                'cancel',
                'containment',
                'delay',
                'distance',
                'ghost',
                'grid',
                'handles',
                'helper',
                'maxHeight',
                'maxWidth',
                'minHeight',
                'minWidth' ];

        return {
            restrict:"A",
            scope:getScopeDefinition(eventNames, optionNames),
            link:getDefaultLinkFunc('resizable', eventNames, optionNames)
        };
    });
    
    
    
    /**
     * Define a directive for jQueryUI dialog.
     *
     * @link http://jqueryui.com/dialog/
     */
    angular.module('ui.jquery.dialog', []).directive('dialog', function juiDialog() {
        var eventNames = [
                    	'beforeClose',
                    	'close',
                    	'drag',
                    	'dragStart',
                    	'dragStop',
                    	'focus',
                    	'open',
                    	'resize',
                    	'resizeStart',
                    	'resizeStop'],
            optionNames = [
                       	'appendTo',
                    	'autoOpen',
                    	'buttons',
                    	'closeOnEscape',
                    	'closeText',
                    	'dialogClass',
                    	'draggable',
                    	'hide',
                    	'height',
                    	'maxHeight',
                    	'maxWidth',
                    	'minHeight',
                    	'minWidth',
                    	'modal',
                    	'resizable',
                    	'show',
                    	'title',
                    	'position',
                    	'width'];

        return {
            restrict:'EA',
            replace:true,
            transclude: true,
            template:"<div ng-transclude></div>",
            scope:getScopeDefinition(eventNames, optionNames),
            link:getDefaultLinkFunc('dialog', eventNames, optionNames)
        };
    });
    
    
}());

