$(document).ready(function() {  
  // Whenever we click a cell in the table we trigger event. 
  $(".cell").on('click', function(){
    var id = this.id.slice(-1);
    var cellValue = document.getElementById(this.id).innerHTML;

    // Validates current players move
    $(function(){
      switch (cellValue) {
        case 'X':
          $('#status').html('Invalid move X. Try again!').attr('class', 
          'alert alert-warning');
          break;
        case 'O':
          $('#status').html('Invalid move O. Try again!').attr('class', 
          'alert alert-warning');  
          break;
        default:
          $('#status').html('Successful move!').attr('class', 
          'alert alert-success');  
          setMark();
          break;
      }      
    })

    // Resets the board
    $(".btn").on('click', function reset (){
      for (var i = 1; i < 10; i++){
        document.getElementById('cID'+i).innerHTML = "";        
      }
      $("#game-over").replaceWith("<p id='game-over'></p>");   
      $.ajax({
        url: "/newBoard",
        type: "post", 
        success: function(data) {        
          $('#status').html('New Game!').attr('class', 
          'alert alert-success');
        },
        error: function(data) {
            $('#status').html('Error! Request failed.').attr('class',
            'alert alert-warning');
        }
      });
    }); 

    // Place a mark into the cell
    function setMark(){
      $.ajax({
        url: "/",
        dataType: 'text',
        type: "post", 
        data: "id=" + id,
        success: function(data) {        
          togglePlayerStatus(data);
          document.getElementById("cID"+id).innerHTML = data;
          checkVictory();
        },
         error: function(data) {
          $('#status').html('Error! Request failed.').attr('class',
          'alert alert-warning');
        }
      });
    }

    // Toggles the status msg, telling us which players turn it is.
    function togglePlayerStatus(data){
      switch (data) {
        case 'X':
          $('#current-player').html('O');      
          break;
        case 'O':
          $('#current-player').html('X');        
          break;
        default:
          $('#status').html('Unknown error!').attr('class',
          'alert alert-warning');
          break;
      }
    }
  });  

  // Check for victory
  function checkVictory(){
    $.ajax({
      url: "/hasWon",
      dataType: 'text',      
      type: "post", 
      success: function(data) {  
        switch (data) {
          case 'X':
          $('#game-over')
          .html('Player X is a winner, continue your game or reset.').attr('class',
          'alert alert-warning');            
            break;
          case 'O':
          $('#game-over')
          .html('Player O is a winner, continue your game or reset.').attr('class',
          'alert alert-warning');            
            break;
          default:
            break;
        }
      },
      error: function(data) {
        $('#status').html('Error has occured!').attr('class',
        'alert alert-warning');    
      }
    });
  }
});