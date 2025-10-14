document.addEventListener("DOMContentLoaded", () => {
    const navItems = document.querySelectorAll('.nav-item');
    const toggleSiblingClass = (items, index, offset, className, add) => {
      const sibling = items[index + offset];
      if (sibling) {
        sibling.classList.toggle(className, add);
      }
    };
    
    navItems.forEach((item, index) => {
      item.addEventListener('mouseenter', () => {
        item.classList.add('hover'); 
        
        toggleSiblingClass(navItems, index, -1, 'sibling-close', true); 
        toggleSiblingClass(navItems, index, 1, 'sibling-close', true);  
        toggleSiblingClass(navItems, index, -2, 'sibling-far', true);   
        toggleSiblingClass(navItems, index, 2, 'sibling-far', true);    
      });
      item.addEventListener('mouseleave', () => {
        item.classList.remove('hover'); 
        
        toggleSiblingClass(navItems, index, -1, 'sibling-close', false); 
        toggleSiblingClass(navItems, index, 1, 'sibling-close', false);  
        toggleSiblingClass(navItems, index, -2, 'sibling-far', false);   
        toggleSiblingClass(navItems, index, 2, 'sibling-far', false);    
      });
    });
  });