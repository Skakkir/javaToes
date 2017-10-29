$(document).ready(function() {  
  
  // Whenever we click a cell in the table we trigger event. 
  $(".cell").on('click', function(){
    alert('test');
    var id = this.id.slice(-1);
    var cellValue = document.getElementById(this.id).innerHTML;
    
    // Validate move
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

    // place mark into the cell
    function setMark(){
      $.ajax({
        url: "/",
        dataType: 'text',
        type: "post", 
        data: "id=" + id,
        success: function(data) {        
          togglePlayerStatus(data);
          document.getElementById("cID"+id).innerHTML = data;
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

  // Reset the board
  $(".btn").on('click', function(){
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
});